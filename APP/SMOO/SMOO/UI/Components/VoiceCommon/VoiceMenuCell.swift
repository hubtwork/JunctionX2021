//
//  VoiceMenuCell.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import SwiftUI

struct VoiceMenuCell: View {
    
    /// Profile
    let user: UserForColumn
    
    var body: some View {
        GeometryReader { geometry in
            ZStack {
                
                OnOffWrapper
                
                userInfoWrapper
            }
            .frame(width: geometry.size.width,
                   height: geometry.size.height)
            .background(Color.smooGray)
            .cornerRadius(10)
        }
                
    }
    
    var OnOffWrapper: some View {
        HStack {
            // ON / OFF
            Spacer()
            Circle()
                .frame(width: 15, height: 15)
                .foregroundColor(user.isSpeaking ? Color.smooGreen : (user.isEnabled ? Color.gray : Color.red))
        }.padding(.horizontal, 20)
    }
    
    var userInfoWrapper: some View {
        VStack {
            Spacer()
            userTextInfo
        }.padding(.leading, 20)
        .padding(.bottom, 20)
    }
    
    
    var userTextInfo: some View {
        VStack(spacing: 5) {
            HStack {
                Text("Name: \(user.userName)")
                    .font(.system(size: 18))
                    .bold()
                    .foregroundColor(Color.white)
                Spacer()
            }
            HStack {
                Text("Position: \(user.userPosition)")
                    .font(.system(size: 18))
                    .bold()
                    .foregroundColor(Color.white)
                Spacer()
            }
        }
    }
}

struct VoiceMenuCell_Previews: PreviewProvider {
    static var previews: some View {
        VoiceMenuCell(user: UserForColumn(userName: "kim changhyun", userProfileURL: "", userPosition: "Staff", isSpeaking: false, isEnabled: true))
            .frame(height: UIScreen.screenHeight * 0.1)
            .padding(.horizontal, 20)
            .previewDevice("iPhone 12")
    }
}
