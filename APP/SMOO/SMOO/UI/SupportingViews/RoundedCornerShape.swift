//
//  RoundedCornerShape.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import SwiftUI

struct RoundedCornerShape: Shape {

    var radius: CGFloat = .infinity
    var corners: UIRectCorner = .allCorners

    func path(in rect: CGRect) -> Path {
        let path = UIBezierPath(roundedRect: rect, byRoundingCorners: corners, cornerRadii: CGSize(width: radius, height: radius))
        return Path(path.cgPath)
    }
}

extension View {
    func cornerRadius(_ radius: CGFloat, corners: UIRectCorner) -> some View {
        clipShape( RoundedCornerShape(radius: radius, corners: corners) )
    }
}
