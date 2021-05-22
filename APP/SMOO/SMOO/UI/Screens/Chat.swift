//
//  Chat.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct Chat: View {
    var body: some View {
        content
    }
}

extension Chat {
    
    var content: some View {
        ZStack {
            menu
        }
    }
    
    var menu: some View {
        VStack {
            Spacer()
            LazyHStack(spacing: 0) {
                ChatRoomMenuColumn(isSelected: .constant(true), title: "Voice")
                ChatRoomMenuColumn(isSelected: .constant(true), title: "Chat")
                ChatRoomMenuColumn(isSelected: .constant(true), title: "Map")
                ChatRoomMenuColumn(isSelected: .constant(true), title: "Documents")
            }
            .padding(.leading, 20)
            .frame(width: UIScreen.screenWidth)
            Spacer()
        }
    }
    
}

struct Chat_Previews: PreviewProvider {
    static var previews: some View {
        Chat()
            .previewDevice("iPhone 12")
    }
}
