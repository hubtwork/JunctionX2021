//
//  ContentView.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI
import Combine

struct ContentView: View {
    
    private let container: DIContainer
    @State private var isSigned: Bool = false
    
    init(container: DIContainer) {
        self.container = container
    }
    
    var body: some View {
        ZStack {
            if isSigned {
                MainMenu(eventTitle: "2021 MS Conference", userList: UsersList.mocked)
                    .inject(container)
            } else {
                Signing()
                    .inject(container)
            }
        }
        .animation(.easeInOut)
        .onReceive(signInStateUpdate) { self.isSigned = $0 }
    }
    
    private var signInStateUpdate: AnyPublisher<Bool, Never> {
        container.appState.updates(for: \.system.isSigned)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(container: AppEnvironment.bootstrap().container)
            .previewDevice("iPhone 12")
    }
}
