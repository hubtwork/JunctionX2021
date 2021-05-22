//
//  ChatSection.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatSection: View {
    
    let title: String
    
    var body: some View {
        HStack {
            Text(title)
                .font(.custom("TypeFace", size: 20))
                .bold()
                .foregroundColor(Color.smooGray)
            Spacer()
        }
        .padding(.vertical, 10)
        .padding(.horizontal, 10)
        .background(Color.white)
    }
}

struct ChatSection_Previews: PreviewProvider {
    static var previews: some View {
        ChatSection(title: "Team #1")
    }
}
