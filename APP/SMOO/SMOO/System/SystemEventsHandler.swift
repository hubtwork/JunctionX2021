//
//  SystemEventsHandler.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import UIKit
import Combine

protocol SystemEventsHandler {
    func sceneDidBecomeActive()
    func sceneWillResignActive()
}

struct SmooSystemEventsHandler: SystemEventsHandler {
    
    let appState: Store<AppState>
    private var subscriptions = Set<AnyCancellable>()
    
    init(appState: Store<AppState>) {
        self.appState = appState
    }
    
    func sceneDidBecomeActive() {
        appState[\.system.isActive] = true
    }
    
    func sceneWillResignActive() {
        appState[\.system.isActive] = false
    }
}
