//
//  AppState.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI
import Combine

struct AppState: Equatable {
    
    var userData = UserData(token: nil)
    var routing = ViewRouting()
    var system = System()
    
}

extension AppState {
    struct UserData: Equatable {
        let token: String?
    }
}

extension AppState {
    struct ViewRouting: Equatable {
        
    }
}

extension AppState {
    struct System: Equatable {
        var isActive: Bool = true
        
        var isSigned: Bool = false
    }
}

func == (lhs: AppState, rhs: AppState) -> Bool {
    return lhs.userData == rhs.userData &&
        lhs.routing == rhs.routing &&
        lhs.system == rhs.system
}

#if DEBUG
extension AppState {
    static var preview: AppState {
        var state = AppState()
        state.system.isActive = true
        return state
    }
}
#endif
