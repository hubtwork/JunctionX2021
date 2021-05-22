//
//  TextChatMenuButton.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct TextChatMenuButton: View {
    
    let hasNewContent: Binding<Bool>
    /// Topic Components
    let topicCount: Int
    
    var body: some View {
        GeometryReader { geometry in
            ZStack {
                if hasNewContent.wrappedValue {
                    NewContentWrapper
                }
                TitleWrapper
                
                TopicWrapper
            }
            .frame(width: geometry.size.width,
                   height: geometry.size.height)
            .background(Color.smooGray)
            .cornerRadius(15)
        }
                
    }
    
    var NewContentWrapper: some View {
        VStack {
            HStack {
                Text("New !")
                    .font(.custom("ITC Avant Garde Gothic Bold", size: 15))
                    .foregroundColor(Color.white)
                
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
    
    var TopicWrapper: some View {
        VStack {
            Spacer()
            topicText
        }.padding(.leading, 25)
        .padding(.bottom, 20)
    }
    
    var menuText: some View {
        HStack {
            Text("Chat")
                .font(.custom("ITC Avant Garde Gothic Bold", size: 22))
                .bold()
                .foregroundColor(Color.white)
            Spacer()
        }
    }
    var topicText: some View {
        HStack {
            Text("\(topicCount) topics")
                .font(.system(size: 15))
                .foregroundColor(Color.white)
            Spacer()
        }
    }
}

struct TextChatMenuButton_Previews: PreviewProvider {
    static var previews: some View {
        TextChatMenuButton(hasNewContent: .constant(true), topicCount: 10)
    }
}
