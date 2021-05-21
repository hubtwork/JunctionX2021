//
//  CodeTextField.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

struct CodeTextField: View {
    
    let text: Binding<String>
    let fontSize: CGFloat
    let bgColor: Color
    
    init(
        text: Binding<String>,
        fontSize: CGFloat = 20,
        bgColor: Color = .gray
    ) {
        self.text = text
        self.fontSize = fontSize
        self.bgColor = bgColor
    }
    
    var body: some View {
        GeometryReader { geometry in
            ZStack {
                if text.wrappedValue.isEmpty {
                    Text("Enter the Code")
                        .bold()
                        .font(.system(size: fontSize))
                        .multilineTextAlignment(.center)
                        .foregroundColor(Color.gray)
                }
                TextField("", text: text)
                    .multilineTextAlignment(.center)
                    .font(.system(size: fontSize))
                    .frame(width: geometry.size.width)
                    .foregroundColor(Color.black)
                    .background(bgColor.opacity(0.1))
                    .overlay(
                        VStack{
                            Divider()
                                .frame(height:2)
                                .background(Color.black)
                                .offset(x: 0, y: 18)
                        }
                    )
            }
        }
    }
}

struct CodeTextFieldSample: View {
    @State var code: String = ""
    var body: some View {
        VStack {
            Spacer()
            CodeTextField(text: $code)
                .frame(height: 100)
            Spacer()
        }
    }
}

struct CodeTextField_Previews: PreviewProvider {
    static var previews: some View {
        CodeTextFieldSample()
    }
}
