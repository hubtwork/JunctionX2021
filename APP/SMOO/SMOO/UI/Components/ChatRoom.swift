//
//  ChatRoom.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatRoom: View {
    
    @State private var selectedIndex: Int = 0
    
    @State private var selected = [true, false, false, false]
    
    var body: some View {
        content
            .onChange(of: selectedIndex, perform: { value in
                selected = [false, false, false, false]
                selected[value] = true
            })
        
    }
}

extension ChatRoom  {
    
    var content: some View {
        VStack(spacing: 0) {
            menu
            chatContents
        }
        .padding(.leading, 20)
    }
    
    var menu: some View {
        ScrollView( .horizontal, showsIndicators: false) {
            HStack(spacing: 0) {
                Button(action: { selectedIndex = 0 }) {
                    ChatRoomMenuColumn(isSelected: .constant(selected[0]), title: "Voice")
                }
                Button(action: { selectedIndex = 1 }) {
                    ChatRoomMenuColumn(isSelected: .constant(selected[1]), title: "Chat")
                }
                
                Button(action: { selectedIndex = 2 }) {
                    ChatRoomMenuColumn(isSelected: .constant(selected[2]), title: "Map")
                }
                
                Button(action: { selectedIndex = 3 }) {
                    ChatRoomMenuColumn(isSelected: .constant(selected[3]), title: "Documents")
                }
            }
        }.frame(width: .infinity)
    }
    
    var chatContents: some View {
        GeometryReader { geometry in
            VStack {
                
            }.frame(width: geometry.size.width,
                    height: geometry.size.height)
            .background(Color.gray.opacity(0.05))
            .padding(.leading, 1)
        }
    }
    
    
    
}

struct ChatRoom_Previews: PreviewProvider {
    static var previews: some View {
        ChatRoom()
            .previewDevice("iPhone 12")
    }
}
