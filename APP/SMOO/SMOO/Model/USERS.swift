//
//  Speaker.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import Foundation


struct User: Codable, Equatable {
    
    let userId: String
    
    let groupId: Int
    let channelId: Int
    
    let userName: String
    let userProfileURL: String
    
    let isSpeaking: Bool
    let isEnabled: Bool
    
}

struct UserForColumn: Codable, Equatable, Hashable {
    let userName: String
    let userProfileURL: String
    
    let isSpeaking: Bool
    let isEnabled: Bool
}

struct UserColumn: Codable, Equatable, Hashable {
    let channelName: String
    let users: [UserForColumn]
}

struct UsersList: Codable, Equatable {
    let columns: [UserColumn]
    
    static let mocked: UsersList = UsersList(
        columns: [
            UserColumn(channelName: "Organizing Office",
                                         users: [
                                            UserForColumn(userName: "kim changhyun", userProfileURL: "", isSpeaking: true, isEnabled: true),
                                            UserForColumn(userName: "baek kimchi", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "lee jinsung", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "heo jae", userProfileURL: "", isSpeaking: false, isEnabled: false)
                                        ]),
            UserColumn(channelName: "10:30 Confference",
                                         users: [
                                            UserForColumn(userName: "lee dohyun", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "lee kyungsup", userProfileURL: "", isSpeaking: false, isEnabled: true)
                                        ]),
            UserColumn(channelName: "Attendance",
                                         users: [
                                            UserForColumn(userName: "kim sungjin", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "baek minkyu", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "heo hyunjun", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "lee changsup", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "oh jaehyuk", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "lee kyungsup", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "chae hyunwook", userProfileURL: "", isSpeaking: false, isEnabled: true),
                                            UserForColumn(userName: "micro soft", userProfileURL: "", isSpeaking: false, isEnabled: true)
                                        ])]
    )
}

