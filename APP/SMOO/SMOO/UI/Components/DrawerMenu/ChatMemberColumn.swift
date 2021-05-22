//
//  ChatMemberColumn.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatMemberColumn: View {
    
    let isSpeaking: Binding<Bool>
    let memberName: String
    
    var body: some View {
        HStack {
            if isSpeaking.wrappedValue {
                Image(systemName: "speaker.wave.2")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 20)
                    .foregroundColor(Color.white)
            } else {
                VStack{}.frame(width: 30)
            }
            Text(memberName)
                .font(.system(size: 20))
                .bold()
                .foregroundColor(Color.white)
            Spacer()
        }
        .padding(.leading, 20)
        .padding(.top, 5)
        .padding(.bottom, 10)
    }
}

struct ChatMemberColumn_Previews: PreviewProvider {
    static var previews: some View {
        ChatMemberColumn(isSpeaking: .constant(true), memberName: "Member")
            .background(Color.smooGray)
    }
}
