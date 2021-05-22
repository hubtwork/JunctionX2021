//
//  Chat.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct Chat: View {
    
    let eventTitle: String
    
    var body: some View {
        content
    }
}

extension Chat {
    
    var content: some View {
        ZStack {
            
            VStack {
                titleBar
                MainMenu()
            }
        }
    }
    
    var titleBar: some View {
        ZStack {
            HStack {
                Image(systemName: "line.horizontal.3")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 25, height: 25)
                Spacer()
            }
            HStack {
                Spacer()
                
                Text(eventTitle)
                    .font(.custom("ITC Avant Garde Gothic Bold", size: 30))
                    .foregroundColor(Color.smooGreen)
                
                Spacer()
            }
        }.padding(.leading, 20)
    }
}

struct Chat_Previews: PreviewProvider {
    static var previews: some View {
        Chat(eventTitle: "Junction X")
            .previewDevice("iPhone 12")
    }
}
