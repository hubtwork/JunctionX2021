//
//  RoundButton.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct RoundButton: View {
    
    let textColor: Color
    let bgColor: Color
    let width: CGFloat
    let height: CGFloat
    let strokeColor: Color
    let strokeWidth: CGFloat
    let radius: CGFloat
    
    let text: String
    let textSize: CGFloat
    
    let fontName: String = "NanumGothicBold"
    
    init(textColor: Color = .black,
         bgColor: Color = .white,
         width: CGFloat = UIScreen.screenWidth * 0.8,
         height: CGFloat = 30,
         strokeColor: Color = .black,
         strokeWidth: CGFloat = 2,
         radius: CGFloat = 10,
         text: String,
         textSize: CGFloat = 20
    ) {
        self.textColor = textColor
        self.bgColor = bgColor
        self.width = width
        self.height = height
        self.strokeColor = strokeColor
        self.strokeWidth = strokeWidth
        self.text = text
        self.radius = radius
        self.textSize = textSize
    }
    
    var body: some View {
        GeometryReader { geometry in
            Text(text)
                .font(.custom(fontName, size: textSize))
                .bold()
                .padding()
                .frame(minWidth: 0, maxWidth: geometry.size.width, minHeight: 0, maxHeight: height, alignment: .center)
                .background(bgColor)
                .foregroundColor(textColor)
                .clipShape(RoundedRectangle(cornerRadius: radius))
                .overlay(
                  RoundedRectangle(cornerRadius: radius)
                    .stroke(strokeColor, lineWidth: strokeWidth)
                )
        }.frame(height: height)
    }
}

struct RoundButton_Previews: PreviewProvider {
    static var previews: some View {
        RoundButton(text: "Example")
    }
}
