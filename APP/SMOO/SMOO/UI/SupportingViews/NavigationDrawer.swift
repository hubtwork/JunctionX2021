//
//  NavigationDrawer.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct NavigationDrawer: View {
    
    private let width = UIScreen.screenWidth - 100
    let isOpen: Binding<Bool>
    
    init(
        isOpen: Binding<Bool>
    ) {
        self.isOpen = isOpen
    }
    
    var body: some View {
        HStack {
            /// Drawer Contents
            VStack {
                
            }.frame(width: UIScreen.screenWidth,
                    height: UIScreen.screenHeight)
            .background(Color.black)
            .offset(x: isOpen.wrappedValue ? 0 : -self.width)
            .animation(.default)
            
            Spacer()
        }
    }
}

struct NavigationDrawerSample: View {
    
    @State var isOpen: Bool = false
    
    var body: some View {
        ZStack {
            if !isOpen {
                
            }
            
            NavigationDrawer(isOpen: $isOpen)
        }
    }
}

struct NavigationDrawer_Previews: PreviewProvider {
    static var previews: some View {
        NavigationDrawerSample()
    }
}
