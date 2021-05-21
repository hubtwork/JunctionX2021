//
//  AppEnvironment.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import UIKit
import Combine

struct AppEnvironment {
    let container: DIContainer
    let systemEventsHandler: SystemEventsHandler
}


extension AppEnvironment {
    
    static func bootstrap() -> AppEnvironment {
        let appState = Store<AppState>(AppState())
        let session = configuredURLSession()
        let apiRepositories = configuredApiRepositories(session: session)
        let interactors = configuredInteractors(appState: appState, apiRepositories: apiRepositories)
        let systemEventsHandler = SmooSystemEventsHandler(appState: appState)
        let diContainer = DIContainer(appState: appState, interactors: interactors)
        return AppEnvironment(container: diContainer,
                              systemEventsHandler: systemEventsHandler)
    }
    
    private static func configuredURLSession() -> URLSession {
        let configuration = URLSessionConfiguration.default
        configuration.timeoutIntervalForRequest = 60
        configuration.timeoutIntervalForResource = 120
        configuration.waitsForConnectivity = true
        configuration.httpMaximumConnectionsPerHost = 5
        //configuration.requestCachePolicy = .returnCacheDataElseLoad
        return URLSession(configuration: configuration)
    }
    
    private static func configuredApiRepositories(session: URLSession) -> ApiRepositoriesContainer {
        
        return .init()
    }
    
    private static func configuredInteractors(appState: Store<AppState>,
                                              apiRepositories: ApiRepositoriesContainer
    ) -> DIContainer.Interactors {
        
        return .init()
    }
}

private extension AppEnvironment {
    struct ApiRepositoriesContainer {
        
    }
}


