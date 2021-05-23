//
//  CHAT.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//



struct ChatDTO : Equatable, Decodable {
    
    let userName: String
    let userProfileURL: String
    let userPosition: String
    
    let timestamp: String
}

struct DriveDTO : Equatable, Decodable {
    
    let userName: String
    let userPosition: String
    
    let timestamp: String
    
    let fileName: String
    let filePath: String
    let fileType: String
    
    let filrAuthority: String
    
}

