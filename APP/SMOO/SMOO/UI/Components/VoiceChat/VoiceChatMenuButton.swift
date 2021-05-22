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
    
    /// Topic Components
    let topicCount: Int
    
    var body: some View {
        GeometryReader { geometry in
            ZStack {
                
                OnOffWrapper
                
                TitleWrapper
                
                TopicWrapper
            }
            .frame(width: geometry.size.width,
                   height: geometry.size.height)
            .background(Color.smooGray)
            .cornerRadius(15)
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
                
                if isOn.wrappedValue {
                    Text("Stable")
                        .font(.custom("ITC Avant Garde Gothic Bold", size: 15))
                        .foregroundColor(Color.smooGreen)
                } else {
                    Text("Disabled")
                        .font(.custom("ITC Avant Garde Gothic Bold", size: 15))
                        .foregroundColor(Color.red)
                }
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
            Text("Voice")
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

struct VoiceChatMenuButton_Previews: PreviewProvider {
    static var previews: some View {
        VoiceChatMenuButton(isOn: .constant(false), topicCount: 10)
    }
}
