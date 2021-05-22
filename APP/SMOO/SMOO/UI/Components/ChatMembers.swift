//
//  ChatMembers.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatMembers: View {
    
    let isOpen: Binding<Bool>
    
    var animation: Animation
    
    var chatRoomName: [Int: String]
    var chatMembers: [Int: [String]]
    
    var body: some View {
        self.content
    }
}

extension ChatMembers {
    
    var content: some View {
        HStack {
            /// Drawer Menu
            VStack (spacing: 40){
                HStack {
                    /// LOGO
                    Image("logo")
                        .resizable()
                        .frame(width: 170, height: 45)
                }
                .padding(.top, 50)
                
                self.chatRoom
                
            }
            .frame(width: 300,
                   height: UIScreen.screenHeight)
            .background(
                Color.white
                    .ignoresSafeArea(.all, edges: .vertical)
            )
            /// Drawer Button
            Button(action: {
                withAnimation {
                    isOpen.wrappedValue.toggle()}
                }
            ){
                VStack {}.frame(
                    width: 20,
                    height: UIScreen.screenHeight)
                .background(
                    Color.red.opacity(0.1)
                        .ignoresSafeArea(.all, edges: .vertical)
                )
            }
            
            Spacer()
        }
    }
    
    var chatRoom: some View {
        VStack {
            ScrollView {
                ForEach(chatRoomName.sorted(by: <), id: \.key) { key, value in
                    /// Chat Channel Section Header
                    ChatSection(title: value)
                        .border(Color.black)
                    /// Chat Member List
                    LazyVStack(spacing: 0) {
                        ForEach(chatMembers[key]!, id: \.self) { name in
                            ChatMemberColumn(memberName: name)
                                .border(Color.black)
                        }
                    }.padding(.bottom, 20)
                }
            }
            .onAppear {
             UITableView.appearance().separatorStyle = .none
            }
        }
    }

}

struct ChatMembersSample: View {
    
    let chatRooms = [1: "Event A #1", 2: "Event B #2"]
    let chatMembers = [1: ["Lee Jake", "Baek Cadassian"], 2: ["Chae Brian", "Heo Johnson", "Kim Scott"]]
    
    @State var isOpen: Bool = false
    
    var body: some View {
        ZStack {
            
            ChatMembers(isOpen: $isOpen, animation: .spring().delay(2), chatRoomName: chatRooms, chatMembers: chatMembers)
                .offset(x: isOpen ? 0: -300)
        }
    }
}

struct ChatMembers_Previews: PreviewProvider {
    static var previews: some View {
        ChatMembersSample()
            .previewDevice("iPhone 12")
    }
}
