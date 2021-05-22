//
//  TextChatCell.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct TextChatCell: View {
    var body: some View {
        content
    }
}

extension TextChatCell {
    
    var content: some View {
        HStack {
            profileImage
        }
    }
    
    var profileImage: some View {
        Image("shin02")
            .resizable()
            .scaledToFill()
            .frame(width: 74, height: 74)
    }
    
    var profileName: some View {
        Text("profileName")
    }
    
}

struct TextChatCell_Previews: PreviewProvider {
    static var previews: some View {
        TextChatCell()
    }
}
