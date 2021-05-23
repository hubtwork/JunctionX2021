//
//  WebRepository.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//


import Combine
import Foundation

protocol WebRepository: ApiRepository {
    
    /// Sign In and Load all involved Channels
    func signIn(registrationCode: String) -> AnyPublisher<UsersList, Error>
    
    /// Load Involved Voice members
    func loadVoiceMembers(token: String, channelCode: String) -> AnyPublisher<[UserForColumn], Error>
    
    /// Load Text Chatting Items
    func loadTextChats(token: String, channelCode: String) -> AnyPublisher<[ChatDTO], Error>
    
    /// Load Drive data
    func loadSharedDrive(token: String, channelCode: String) -> AnyPublisher<[DriveDTO], Error>
    
    /// Load GPS data for current
    func loadGPS(token: String, channelCode: String) -> AnyPublisher<[UserWithLocation], Error>
    
}

struct SmooLoadableWebRepository: WebRepository {
    func signIn(registrationCode: String) -> AnyPublisher<UsersList, Error> {
        let signInParam = ["code" : registrationCode]
        return request(endpoint: API.signIn, params: signInParam)
    }
    
    func loadVoiceMembers(token: String, channelCode: String) -> AnyPublisher<[UserForColumn], Error> {
        let registrationParams = ["channel": channelCode]
        return request(endpoint: API.loadGPS(token), params: registrationParams)
    }
    
    func loadTextChats(token: String, channelCode: String) -> AnyPublisher<[ChatDTO], Error> {
        let registrationParams = ["channel": channelCode]
        return request(endpoint: API.loadTextChats(token), params: registrationParams)
    }
    
    func loadSharedDrive(token: String, channelCode: String) -> AnyPublisher<[DriveDTO], Error> {
        let registrationParams = ["channel": channelCode]
        return request(endpoint: API.loadVoiceMembers(token), params: registrationParams)
    }
    
    func loadGPS(token: String, channelCode: String) -> AnyPublisher<[UserWithLocation], Error> {
        let registrationParams = ["channel": channelCode]
        return request(endpoint: API.loadSharedDrive(token), params: registrationParams)
    }
    
    
    let session: URLSession
    let baseURL: String
    
    let backgroundQueue = DispatchQueue(label: "bg_parse_queue")
    
    init(session: URLSession, baseURL: String) {
        self.session = session
        self.baseURL = baseURL
    }
    
}

// MARK: - Endpoints

extension SmooLoadableWebRepository {
    enum API {
        case signIn
        
        case loadVoiceMembers(String)
        case loadTextChats(String)
        case loadSharedDrive(String)
        case loadGPS(String)
    }
}

extension SmooLoadableWebRepository.API: ApiRequest {
    
    var path: String {
        switch self {
        case .signIn:
            return "/sign/"
        case .loadVoiceMembers:
            return "/load/voice"
        case .loadTextChats:
            return "/load/chat"
        case .loadSharedDrive:
            return "/load/sharedDrive"
        case .loadGPS:
            return "/"
        }
    }
    
    var method: String {
        switch self {
        case .signIn, .loadGPS, .loadSharedDrive, .loadTextChats, .loadVoiceMembers:
            return "POST"
        }
    }
    
    var headers: [String: String]? {
        switch self {
        case .signIn:
            return ["Accept": "application/json"]
        case let .loadGPS(token), let .loadSharedDrive(token), let .loadTextChats(token), let .loadVoiceMembers(token):
            return ["Authroization": "Bearer \(token)",
                    "Accept": "application/json"]
        }
    }
    
    func body(params: [String: Any] = [:]) throws -> Data? {
        if params.isEmpty { return nil }
        return params
            .map{ $0.key + "=" + "\($0.value)" }
            .joined(separator: "&")
            .data(using: .utf8)
    }
}
