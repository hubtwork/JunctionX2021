//
//  ChatRoom.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatRoom: View {
    
    var body: some View {
        content
    }
}

extension ChatRoom  {
    
    var content: some View {
        VStack {
            LazyHStack {
                Text(" MAP ")
            }
        }
        .padding(.leading, 20)
    }
    
    
}

struct ChatRoom_Previews: PreviewProvider {
    static var previews: some View {
        ChatRoom()
    }
}
