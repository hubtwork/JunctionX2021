//
//  MAP.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import Foundation


struct Location: Codable, Equatable {
    let lat: Double
    let long: Double
}

struct UserLocation: Codable, Equatable {
    var lat: Double
    var long: Double
}

struct UserWithLocation: Codable, Equatable  {
    
    let userName: String
    let userProfileURL: String
    let userPosition: String
    
    let loc: UserLocation
    
    static let mocked: [UserWithLocation] = [
        UserWithLocation(userName: "kim sungjin", userProfileURL: "", userPosition: "Manager", loc: UserLocation(lat: 37.558041, long: 127.000772)),
        UserWithLocation(userName: "baek minkyu", userProfileURL: "", userPosition: "Staff", loc: UserLocation(lat: 37.558345, long: 126.999543)),
        UserWithLocation(userName: "heo hyunjun", userProfileURL: "", userPosition: "Staff", loc: UserLocation(lat: 37.557956, long: 126.999428)),
        UserWithLocation(userName: "lee changsup", userProfileURL: "", userPosition: "Manager", loc: UserLocation(lat: 37.558687, long: 127.000157)),
        UserWithLocation(userName: "oh jaehyuk", userProfileURL: "", userPosition: "Staff", loc: UserLocation(lat: 37.558198, long: 127.000994)),
        UserWithLocation(userName: "lee kyungsup", userProfileURL: "", userPosition: "Staff", loc: UserLocation(lat: 37.558498, long: 126.998924)),
        UserWithLocation(userName: "chae hyunwook", userProfileURL: "", userPosition: "Staff", loc: UserLocation(lat: 37.557373, long: 126.999758)),
        UserWithLocation(userName: "micro soft", userProfileURL: "", userPosition: "Staff", loc: UserLocation(lat: 37.557465, long: 127.001083)),
        
    ]
    
}
