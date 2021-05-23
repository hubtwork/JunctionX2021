//
//  VoiceChatMenuButton.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct VoiceChatMenuButton: View {
    
    /// On / Off Count
    let isOn: Binding<Bool>
    
    var body: some View {
        GeometryReader { geometry in
            HStack(spacing: 0) {
                ZStack {
                    
                    OnOffWrapper
                    
                    TitleWrapper
                    
                }
                .frame(width: geometry.size.width * 0.7,
                       height: geometry.size.height)
                .background(Color.smooGray)
                .cornerRadius(15, corners: .topLeft)
                .cornerRadius(15, corners: .bottomLeft)
                
                VStack {
                    
                }.frame(width: geometry.size.width * 0.3,
                        height: geometry.size.height)
                .background(Color.smooLightGray)
                .cornerRadius(15, corners: .topRight)
                .cornerRadius(15, corners: .bottomRight)
            }
        }
                
    }
    
    var OnOffWrapper: some View {
        VStack {
            HStack {
                // ON / OFF
                Circle()
                    .frame(width: 15, height: 15)
                    .foregroundColor(isOn.wrappedValue ? Color.smooGreen : Color.red)
                Spacer()
            }
            Spacer()
        }.padding(.top, 20)
        .padding(.horizontal, 25)
    }
    
    var TitleWrapper: some View {
        VStack {
            Spacer()
            menuText
        }.padding(.leading, 25)
        .padding(.bottom, 37)
    }
    
    var menuText: some View {
        HStack {
            Text("Voice")
                .font(.custom("ITC Avant Garde Gothic Bold", size: 22))
                .bold()
                .foregroundColor(Color.white)
            Spacer()
        }
    }
    
}

struct VoiceChatMenuButton_Previews: PreviewProvider {
    static var previews: some View {
        VoiceChatMenuButton(isOn: .constant(false))
    }
}
