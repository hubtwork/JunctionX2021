//
//  ChatRoomMenu.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct ChatRoomMenuColumn: View {
    
    let isSelected: Binding<Bool>
    
    /// UI Components
    let title: String
    
    var body: some View {
        VStack {
            Text(title)
                .font(.custom("ITC Avant Garde Gothic Bold", size: 17))
                .bold()
                .foregroundColor( isSelected.wrappedValue ? Color.smooGreen : Color.white)
        }
        .padding(.horizontal, 30)
        .padding(.vertical, 10)
        .background(Color.smooGray)
        .overlay(Rectangle().frame(width: nil, height: 1, alignment: .top).foregroundColor(Color.white), alignment: .top)
        .overlay(Rectangle().frame(width: 1, height: nil, alignment: .leading).foregroundColor(Color.white), alignment: .leading)
        .overlay(Rectangle().frame(width: 1, height: nil, alignment: .trailing).foregroundColor(Color.white), alignment: .trailing)
                
    }
}

struct ChatRoomMenu_Previews: PreviewProvider {
    static var previews: some View {
        VStack(spacing: 10) {
            ChatRoomMenuColumn(isSelected: .constant(true), title: "MAP")
            ChatRoomMenuColumn(isSelected: .constant(false), title: "MAP")
        }
    }
}
