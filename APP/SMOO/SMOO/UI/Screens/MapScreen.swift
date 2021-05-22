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
    
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }

}

extension MapScreen {
    
    var titleBar: some View {
        HStack(spacing: 5){
            Button(action: { presentation.wrappedValue.dismiss() }) {
                Image(systemName: "chevron.backward")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 20, height: 20)
                    
                Text("Voice")
                    .font(.custom("ITC Avant Garde Gothic Bold", size: 20))
                    .foregroundColor(Color.black)
            }.foregroundColor(Color.black)
            Spacer()
            
            Image(systemName: "person.fill")
                .resizable()
                .scaledToFit()
                .frame(width: 20, height: 20)
            Text("11")
                .font(.system(size: 20))
                .foregroundColor(Color.black)
                .padding(.trailing, 20)
            
            Image(systemName: "line.horizontal.3")
                .resizable()
                .frame(width: 25, height: 20)
        }
        .padding(.vertical, 10)
    }
}

struct MapScreen_Previews: PreviewProvider {
    static var previews: some View {
        MapScreen()
            .inject(AppEnvironment.bootstrap().container)
    }
}
