//
//  Extensions.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//


import SwiftUI

extension UIScreen{
    static let screenWidth = UIScreen.main.bounds.size.width
    static let screenHeight = UIScreen.main.bounds.size.height
    static let screenSize = UIScreen.main.bounds.size
}


extension Color {
    static let smooGreen = Color("SmooGreen")
    static let smooGray = Color("SmooGray")
}

extension View {
    func border(width: CGFloat, edges: [Edge], color: Color) -> some View {
        overlay(EdgeBorder(width: width, edges: edges).foregroundColor(color))
    }
}
