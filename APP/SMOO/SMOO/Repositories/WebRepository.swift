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
    func loadVoiceMembers(channelCode: String) -> AnyPublisher<[UserForColumn], Error>
    
    /// Load Text Chatting Items
    func loadTextChats(channelCode: String) -> AnyPublisher<[ChatDTO], Error>
    
    /// Load Drive data
    func loadSharedDrive(channelCode: String) -> AnyPublisher<[DriveDTO], Error>
    
    /// Load GPS data for current
    func loadGPS(channelCode: String) -> AnyPublisher<[UserWithLocation], Error>
    
}
