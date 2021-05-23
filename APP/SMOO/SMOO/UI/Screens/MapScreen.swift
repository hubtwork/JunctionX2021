//
//  MapScreen.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import SwiftUI

struct MapScreen: View {
    
    @Environment(\.injected) private var injected: DIContainer
    @Environment(\.presentationMode) var presentation
    
    let users: [UserWithLocation]
    
    var body: some View {
        content
            .navigationBarHidden(true)
    }

}

extension MapScreen {
    
    var content: some View {
        ZStack {
            /// Title Bar & Map Area Collaboration
            VStack(spacing: 1) {
                titleBar
                    .padding(.horizontal, 20)
                Divider().background(Color.black)
                mapArea
            }

        }
    }
    
    var mapArea: some View {
        GoogleMapsView(eventLocation: Location(lat: 37.558148, long: 127.000165), users: users)
            .ignoresSafeArea(.all, edges: .bottom)
    }
    
    var titleBar: some View {
        HStack(spacing: 5){
            Button(action: { presentation.wrappedValue.dismiss() }) {
                Image(systemName: "chevron.backward")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 20, height: 20)
                    
                Text("Map")
                    .font(.custom("ITC Avant Garde Gothic Bold", size: 20))
                    .foregroundColor(Color.black)
            }.foregroundColor(Color.black)
            Spacer()
        }
        .padding(.vertical, 10)
    }
}

struct MapScreen_Previews: PreviewProvider {
    static var previews: some View {
        MapScreen(users: UserWithLocation.mocked)
            .inject(AppEnvironment.bootstrap().container)
            .previewDevice("iPhone 12")
    }
}
