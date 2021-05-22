//
//  Signing.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct Signing: View {
    
    @Environment(\.injected) private var injected: DIContainer
    
    @State var code: String = ""
    
    var body: some View {
        self.content
    }
}

extension Signing {
    
    var content: some View {
        ZStack {
            /// Logo & code Field
            logoBoundary
            codeBoundary
            
            buttonBoundary
        }
    }
    
    var logoBoundary: some View {
        VStack {
            Spacer()
            /// Logo
            VStack{
                
            }
            .frame(width: UIScreen.screenWidth * 0.5,
                    height: UIScreen.screenWidth * 0.3)
            .border(Color.black, width: 1)
            .padding(.bottom, 200)
            Spacer()
        }
    }
    
    var codeBoundary: some View {
        VStack {
            Spacer()
            CodeTextField(text: $code,
                          fontSize: 20,
                          bgColor: Color.white)
                .frame(height: 30)
            Spacer()
        }
        .padding(.top, 30)
        .padding(.horizontal, 60)
    }
    
    var buttonBoundary: some View {
        VStack {
            HStack {
                Spacer()
                Image(systemName: "plus.circle")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 30, height: 30)
            }.padding(.top, 20)
            .padding(.trailing, 20)
            Spacer()
        }
    }
    
}

struct Signing_Previews: PreviewProvider {
    static var previews: some View {
        Signing()
            .inject(.preview)
    }
}
