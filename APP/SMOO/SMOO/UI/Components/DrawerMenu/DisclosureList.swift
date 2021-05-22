//
//  DisclosureList.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct DrawerUserCell: View {
    let user: UserForColumn
    
    var body: some View {
        HStack {
            if user.isSpeaking {
                Image(systemName: "speaker.wave.2")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 20, height: 20)
                    .foregroundColor(Color.white)
            } else {
                VStack{}.frame(width: 30)
            }
            Text(user.userName)
                .font(.system(size: 20))
                .bold()
                .foregroundColor(Color.white)
            
            Circle()
                .frame(width: 10, height: 10)
                .foregroundColor(user.isEnabled ? Color.smooGreen : Color.red)
            Spacer()
        }
        .padding(.leading, 20)
    }
}

struct CollapsibleList: View {
    
    @State private var isCollapse: Bool = true
    
    let channelName: String
    let members: [UserForColumn]
    
    var body: some View {
        VStack {
            content
        }
    }
}

extension CollapsibleList {
    
    var content: some View {
        VStack(spacing: 0) {
            Button(action: {
                withAnimation {
                    isCollapse.toggle()
                }
            }) {
                titleBar
            }
            if !isCollapse {
                preparedUserList
                    .animation(.spring())
            }
        }
        .padding(.horizontal, 10)
        .background(Color.smooGray)
    }
    
    var titleBar: some View {
        HStack {
            Text("\(channelName) ( \(members.count) )")
                .font(.custom("ITC Avant Garde Gothic Bold", size: 20))
                .bold()
                .foregroundColor($isCollapse.wrappedValue ? Color.white : Color.smooGreen)
            Spacer()
        }.padding(.vertical, 10)
    }
    
    var preparedUserList: some View {
        VStack(alignment: .leading) {
            ForEach(members, id: \.self) { user in
                DrawerUserCell(user: user)
            }
        }.padding(.bottom, 10)
    }
}

struct CollapsibleListSample: View {
    let members: [UserForColumn] = [
        UserForColumn(userName: "kim", userProfileURL: "", userPosition: "Staff", isSpeaking: true, isEnabled: true),
        UserForColumn(userName: "baek", userProfileURL: "", userPosition: "Manager", isSpeaking: false, isEnabled: true),
        UserForColumn(userName: "lee", userProfileURL: "", userPosition: "Staff", isSpeaking: false, isEnabled: true),
        UserForColumn(userName: "heo", userProfileURL: "", userPosition: "Staff", isSpeaking: false, isEnabled: false)
    ]
    
    let userList = UsersList.mocked
    
    var body: some View {
        VStack(spacing: 0){
            VStack {}.frame(width: 100, height: 300)
            ScrollView {
                VStack(spacing: 0) {
                    ForEach(userList.columns, id: \.self) { channel in
                        CollapsibleList(channelName: channel.channelName, members: channel.users)
                    }
                }
            }.background(Color.smooGray)
        }
    }
}

struct CollapsibleList_Previews: PreviewProvider {
    static var previews: some View {
        CollapsibleListSample()
            .previewDevice("iPhone 12")
    }
}
