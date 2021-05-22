//
//  TextChatScreen.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import SwiftUI

struct TextChatScreen: View {
    
    let userCount: Int
    
    @State private var inputText: String = ""
    
    var body: some View {
        content
    }
}

extension TextChatScreen {
    
    var content: some View {
        ZStack {
            /// Title Bar
            VStack(spacing: 5) {
                titleBar
                    .padding(.horizontal, 20)
                Divider().background(Color.black)
                Spacer()
            }
            /// Chat Area
            VStack {
                VStack{}.frame(height: 60)
                chatArea
            }
            /// Chat Input Area
            VStack {
                Spacer()
                chatInputArea
                    .background(Color.white)

            }.padding(.horizontal, 20)
            .padding(.bottom, 10)
            
        }
    }
    
    var chatInputArea: some View {
        HStack {
            Image(systemName: "plus.circle.fill")
                .resizable()
                .scaledToFit()
                .frame(width: 30, height: 30)
            ZStack{
                HStack {
                    Spacer()
                    Image(systemName: "face.smiling")
                        .resizable()
                        .scaledToFit()
                        .frame(width: 20, height: 20)
                }
                HStack {
                    TextField("", text: $inputText)
                        .font(.system(size: 17))
                }
            }.padding(.leading, 15)
            .padding(.trailing, 10)
            .padding(.vertical, 5)
            .background(Capsule().fill(Color.smooGray.opacity(0.2)))
            
            Image(systemName: "message.fill")
                .resizable()
                .scaledToFit()
                .frame(width: 30, height: 30)
        }
    }
    
    var chatArea: some View {
        ScrollView {
            VStack {
                Text("야야")
                Spacer()
            }
        }
    }
    
    var titleBar: some View {
        HStack(spacing: 5){
            Image(systemName: "chevron.backward")
                .resizable()
                .scaledToFit()
                .frame(width: 20, height: 20)
                
            Text("Chat")
                .font(.custom("ITC Avant Garde Gothic Bold", size: 20))
                .foregroundColor(Color.black)
            
            Spacer()
            
            Image(systemName: "person.fill")
                .resizable()
                .scaledToFit()
                .frame(width: 20, height: 20)
            Text("\(userCount)")
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

struct TextChatScreen_Previews: PreviewProvider {
    static var previews: some View {
        TextChatScreen(userCount: 4)
            .previewDevice("iPhone 12")
    }
}
