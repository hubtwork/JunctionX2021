//
//  MapMenuButton.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct MapMenuButton: View {
    
    /// On / Off Count
    let gpsOn: Binding<Bool>
    
    var body: some View {
        GeometryReader { geometry in
            ZStack {
                
                OnOffWrapper
                
                TitleWrapper
                
            }
            .frame(width: geometry.size.width,
                   height: geometry.size.height)
            .background(Color.smooGray)
            .cornerRadius(15)
        }
                
    }
    
    var OnOffWrapper: some View {
        VStack {
            HStack {
                // ON / OFF
                Circle()
                    .frame(width: 15, height: 15)
                    .foregroundColor(gpsOn.wrappedValue ? Color.smooGreen : Color.red)
                Spacer()
                
                if gpsOn.wrappedValue {
                    Text("GPS On")
                        .font(.custom("ITC Avant Garde Gothic Bold", size: 15))
                        .foregroundColor(Color.smooGreen)
                } else {
                    Text("GPS Disabled")
                        .font(.custom("ITC Avant Garde Gothic Bold", size: 15))
                        .foregroundColor(Color.red)
                }
            }
            Spacer()
        }.padding(.top, 20)
        .padding(.horizontal, 25)
    }
    
    var TitleWrapper: some View {
        VStack {
            Spacer()
            menuText
        }.padding(.leading, 25)
        .padding(.bottom, 37)
    }
    
    var menuText: some View {
        HStack {
            Text("Map")
                .font(.custom("ITC Avant Garde Gothic Bold", size: 22))
                .bold()
                .foregroundColor(Color.white)
            Spacer()
        }
    }
}

struct MapMenuButton_Previews: PreviewProvider {
    static var previews: some View {
        MapMenuButton(gpsOn: .constant(true))
    }
}
