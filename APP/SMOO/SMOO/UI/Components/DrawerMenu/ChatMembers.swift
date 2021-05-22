//
//  ChatMembers.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatMembers: View {
    
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
                
                Text(groupName)
                    .font(.custom("ITC Avant Garde Gothic Bold", size: 25))
                    .bold()
                    .foregroundColor(Color.smooGreen)
                
                self.chatRoom
                    .padding(.leading, 5)
                
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
                ForEach(userList.columns, id: \.self) { channel in
                    CollapsibleList(channelName: channel.channelName, members: channel.users)
                }
            }
        }.background(Color.smooGray)
        .onAppear {
            UITableView.appearance().separatorStyle = .none
        }
    }

}

struct ChatMembersSample: View {
    let userList = UsersList.mocked
    
    @State var isOpen: Bool = true
    
    var body: some View {
        ZStack {
            ChatMembers(isOpen: $isOpen, groupName: "Junction X", userList: userList)
        }
    }
}

struct ChatMembers_Previews: PreviewProvider {
    static var previews: some View {
        ChatMembersSample()
            .previewDevice("iPhone 12")
    }
}
