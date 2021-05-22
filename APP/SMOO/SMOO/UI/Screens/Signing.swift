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
                .padding(.horizontal, 60)
            
            buttonBoundary
        }.background(Color.smooGray)
        .ignoresSafeArea(.all)
    }
    
    var logoBoundary: some View {
        VStack {
            Spacer()
            /// Logo
            VStack(spacing: 100) {
                Image("logo")
                    .resizable()
                    .frame(width: 200, height: 55)
                    .padding(.top, 40)
                
                CodeTextField(text: $code,
                              fontSize: 20,
                              bgColor: Color.white)
                    .frame(height: 30)
                    .padding(.bottom, 40)
            }
            .padding()
            .padding(.horizontal, 20)
            .background(Color.white)
            .cornerRadius(20)
            
            Spacer()
            
        }
    }
    
    var buttonBoundary: some View {
        VStack {
            Spacer()
            HStack {
                Spacer()
                Image(systemName: "text.bubble.fill")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 30, height: 30)
                    .foregroundColor(Color.smooGreen)
            }.padding([.trailing, .bottom], 40)
        }
    }
    
}

struct Signing_Previews: PreviewProvider {
    static var previews: some View {
        Signing()
            .inject(.preview).previewDevice("iPhone 12")
    }
}
