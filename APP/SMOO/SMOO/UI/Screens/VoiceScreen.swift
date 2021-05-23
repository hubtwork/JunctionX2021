//
//  VoiceScreen.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import SwiftUI

struct VoiceScreen: View {
    
    @Environment(\.injected) private var injected: DIContainer
    @Environment(\.presentationMode) var presentation
    
    let users: [UserForColumn]
    
    @State private var inputText: String = ""
    
    var body: some View {
        content
            .navigationBarHidden(true)
    }
    
}

extension VoiceScreen {
    var content: some View {
        ZStack {
            /// Title Bar
            VStack(spacing: 5) {
                titleBar
                    .padding(.horizontal, 20)
                Divider().background(Color.black)
                Spacer()
            }
            /// In Voice UserList Area
            VStack {
                VStack{}.frame(height: 70)
                membersList
            }.padding(.horizontal, 20)
            .padding(.bottom, 80)
            /// Voice Input Area
            VStack(spacing: 20) {
                Spacer()
                Divider()
                    .frame(height: 2)
                    .background(Color.black)
                voiceInputArea
                    .background(Color.white)
                    .padding(.horizontal, 20)
                
            }
            .padding(.bottom, 10)

            
        }
    }
    
    var voiceInputArea: some View {
        HStack {
            
            
            Spacer()
            Circle()
                .stroke(Color.black)
                .frame(width: 50, height: 50)
                .foregroundColor(Color.white)
                .overlay(Circle()
                            .frame(width: 35, height: 35)
                            .foregroundColor(Color.red))
            Spacer()
        }
    }
    
    var membersList: some View {
        ScrollView {
            VStack(spacing: 20) {
                ForEach(users, id: \.self) { user in
                    VoiceMenuCell(user: user)
                        .frame(height: UIScreen.screenHeight * 0.1)
                }
                Spacer()
            }
        }
    }
    
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
            Text("\(users.count)")
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

struct VoiceScreen_Previews: PreviewProvider {
    static var previews: some View {
        VoiceScreen(users: UsersList.mocked.columns[2].users)
            .previewDevice("iPhone 12")
    }
}
