//
//  ChatMemberColumn.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatMemberColumn: View {
    
    let memberName: String
    
    var body: some View {
        HStack {
            Text(memberName)
                .font(.custom("ITC Avant Garde Gothic Bold", size: 20))
                .foregroundColor(Color.smooGray)
            Spacer()
        }
        .padding(.leading, 20)
        .padding(.top, 5)
        .padding(.bottom, 10)
    }
}

struct ChatMemberColumn_Previews: PreviewProvider {
    static var previews: some View {
        ChatMemberColumn(memberName: "Member")
    }
}
