//
//  ChatMembers.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatMembers: View {

    let user: UserForColumn

    let isOpen: Binding<Bool>
    
    let groupName: String
    let userList: UsersList
    
    
    
    var body: some View {
        self.content
    }
}

extension ChatMembers {
    
    var content: some View {
        HStack {
            /// Drawer Menu
            VStack (spacing: 20){
                
                Image("logo_greenx2")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 150)
                
                self.chatRoom
                    .padding(.leading, 15)
                
            }.padding(.top, 50)
            .frame(width: 300,
                   height: UIScreen.screenHeight)
            .background(
                Color.smooGray
                    .ignoresSafeArea(.all, edges: .vertical)
            )
            
            Spacer()
        }

    }
    
    var chatRoom: some View {
        ScrollView {
            VStack(spacing: 0) {
                ForEach(Array(zip(userList.columns.indices, userList.columns)), id: \.0) { index, channel in
                    CollapsibleList(channelName: channel.channelName, members: channel.users)
                }
            }
        }.padding(.bottom, 120)
        .background(Color.smooGray)
    }
    

}

struct ChatMembersSample: View {
    let userList = UsersList.mocked
    
    @State var isOpen: Bool = true
    
    var body: some View {
        ZStack {
            ChatMembers(user: UserForColumn(userName: "micro soft", userProfileURL: "https://i.imgur.com/jHOXkpc.png", userPosition: "Staff", isSpeaking: false, isEnabled: true), isOpen: $isOpen, groupName: "2021 MS Conference", userList: userList)
        }
    }
}

struct ChatMembers_Previews: PreviewProvider {
    static var previews: some View {
        ChatMembersSample()
            .previewDevice("iPhone 12")
    }
}
