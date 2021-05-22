//
//  ChatMembers.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatMembers: View {
    
    var animation: Animation
    
    var chatRoomName: [Int: String]
    var chatMembers: [Int: [String]]
    
    var body: some View {
        self.content
    }
}

extension ChatMembers {
    
    var content: some View {
        GeometryReader { geometry in
            VStack (spacing: 40){
                HStack {
                    /// LOGO
                    VStack {}.frame(width: 100, height: 40).border(Color.black, width: 1)
                    Spacer()
                }
                .padding(.top, 40)
                
                self.chatRoom
                
            }
            .frame(width: geometry.size.width * 0.5,
                   height: geometry.size.height)
            .background(
                Color.gray.opacity(0.2)
                    .ignoresSafeArea(.all, edges: .vertical)
            )
        }
    }
    
    var chatRoom: some View {
        VStack {
            List {
                ForEach(chatRoomName.sorted(by: >), id: \.key) { key, value in
                    Section(header: Text(value), content: {
                        ForEach(chatMembers[key]!, id: \.self) { name in
                            Text(name)
                        }
                    }).listStyle(InsetGroupedListStyle())
                }
            }
        }
    }

}

struct ChatMembers_Previews: PreviewProvider {
    static var previews: some View {
        ChatMembers(animation: .spring(), chatRoomName: [1: "행사 A", 2: "행사 B"], chatMembers: [1: ["이도현", "백민규"], 2: ["채현욱", "허재", "김성진"]])
    }
}
