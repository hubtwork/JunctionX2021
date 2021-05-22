//
//  ChatRoomMenu.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatRoomMenuColumn: View {
    
    let title: String
    
    var body: some View {
        Text(title)
            .font(.custom("TypeFace", size: 20))
            .bold()
            .frame(width: 130, height: 50)
            .border(Color.black)
    }
}

struct ChatRoomMenu_Previews: PreviewProvider {
    static var previews: some View {
        ChatRoomMenuColumn(title: "MAP")
    }
}
