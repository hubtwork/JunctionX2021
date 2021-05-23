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
    
    
    /// Load Text Chatting Items

    
    /// Load Drive data
     
    
    /// Load GPS data for current
    
}
