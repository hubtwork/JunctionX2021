//
//  ChatRoom.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct MainMenu: View {
    
    /// Voice
    @State private var voiceStable: Bool = true
    let voiceTopicCount: Int = 17
    
    /// Drive
    @State private var driveHasNewContent: Bool = true
    let driveFileCount: Int = 22
    
    /// GPS
    @State private var gpsOn: Bool = true
    
    var body: some View {
        content
        
    }
}

extension MainMenu  {
    
    var content: some View {
        VStack(spacing: 0) {
            menu
        }
    }
    
    var menu: some View {
        ScrollView(showsIndicators: false) {
            VStack(spacing: 20) {
                VStack{}.frame(height: 20)
                
                Button(action: { voiceStable.toggle() }) {
                    VoiceChatMenuButton(isOn: $voiceStable, topicCount: voiceTopicCount)
                        .frame(height: UIScreen.screenHeight * 0.2)
                }
                Button(action: { print("")}) {
                    ChatRoomMenuColumn(title: "Chat")
                        .frame(height: UIScreen.screenHeight * 0.2)
                }
                
                Button(action: { print("") }) {
                    DriveMenuButton(hasNewContent: $driveHasNewContent, fileCount: driveFileCount)
                        .frame(height: UIScreen.screenHeight * 0.2)
                }
                
                Button(action: { gpsOn.toggle() }) {
                    MapMenuButton(gpsOn: $gpsOn)
                        .frame(height: UIScreen.screenHeight * 0.2)
                }
                
                VStack{}.frame(height: 20)
            }
        }.padding(.horizontal, 20)
        .ignoresSafeArea(.all, edges: [.bottom])
    }
    
}

struct MainMenu_Previews: PreviewProvider {
    static var previews: some View {
        MainMenu()
            .previewDevice("iPhone 12")
    }
}
