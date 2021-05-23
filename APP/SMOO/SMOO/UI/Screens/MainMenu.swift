//
//  ChatRoom.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct MainMenu: View {
    
    @Environment(\.injected) private var injected: DIContainer
    @State var isDrawerOpen: Bool = false
    
    let eventTitle: String
    
    /// Current Chat Channel Members
    let userList: UsersList
    
    /// Voice
    @State private var voiceStable: Bool = true
    
    /// TextChat
    @State private var textHasNewContent: Bool = false
    
    /// Drive
    @State private var driveHasNewContent: Bool = true
    
    /// GPS
    @State private var gpsOn: Bool = true
    
    var body: some View {
        NavigationView {
            content
                .navigationBarHidden(true)
        }
        
    }
}

extension MainMenu  {
    
    var content: some View {
        ZStack {
            VStack(spacing: 0) {
                titleBar
                menu
            }.padding(.top, 50)
            
            if isDrawerOpen {
                Button(action: {
                    withAnimation {
                        isDrawerOpen = false
                    }
                }){
                    VStack {
                    }.frame(width: UIScreen.screenWidth, height: UIScreen.screenHeight)
                    .background(Color.gray.opacity(0.5))
                    .ignoresSafeArea()
                    .edgesIgnoringSafeArea(.all)
                    .animation(.easeInOut)
                }
            }
            ChatMembers(user: UserForColumn(userName: "micro soft", userProfileURL: "", userPosition: "Staff", isSpeaking: false, isEnabled: true), isOpen: $isDrawerOpen, groupName: "Junction X", userList: userList)
                .offset(x: isDrawerOpen ? 0: -300)
        }
    }
    
    var titleBar: some View {
        ZStack {
            HStack {
                Button(action: {
                    withAnimation {
                        isDrawerOpen = true
                    }
                } ) {
                    Image(systemName: "line.horizontal.3")
                        .resizable()
                        .frame(width: 20, height: 16)
                }.foregroundColor(Color.black)
                Spacer()
            }
            HStack {
                Spacer()
                
                Text(eventTitle)
                    .font(.custom("ITC Avant Garde Gothic Bold", size: 22))
                    .bold()
                    .foregroundColor(Color.smooGray)
                
                Spacer()
            }
        }.padding(.horizontal, 20)
        .padding(.bottom, 10)
    }
    
    var menu: some View {
        ScrollView(showsIndicators: false) {
            VStack(spacing: 20) {
                VStack{}.frame(height: 10)
                
                NavigationLink(destination: VoiceScreen(users: userList.columns[2].users)) {
                    VoiceChatMenuButton(isOn: $voiceStable)
                        .frame(height: UIScreen.screenHeight * 0.19)
                }
                NavigationLink(destination: TextChatScreen(userCount: 4)) {
                    TextChatMenuButton(hasNewContent: $textHasNewContent)
                        .frame(height: UIScreen.screenHeight * 0.19)
                }
                
                Button(action: { print("") }) {
                    DriveMenuButton(hasNewContent: $driveHasNewContent)
                        .frame(height: UIScreen.screenHeight * 0.19)
                }
                
                NavigationLink(destination: MapScreen(users: UserWithLocation.mocked)) {
                    MapMenuButton(gpsOn: $gpsOn)
                        .frame(height: UIScreen.screenHeight * 0.19)
                }
                
                VStack{}.frame(height: 20)
            }
        }.padding(.horizontal, 20)
        .ignoresSafeArea(.all, edges: [.bottom])
    }
    
}

struct MainMenu_Previews: PreviewProvider {
    static var previews: some View {
        MainMenu(eventTitle: "2021 MS Conference", userList: UsersList.mocked).inject(AppEnvironment.bootstrap().container)
            .previewDevice("iPhone 12")
    }
}
