//
//  SmooMarker.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import SwiftUI
import UIKit

struct SmooMarker: View {
    
    var body: some View {
        VStack {
            Image(uiImage: createImage(count: 3, name: "Name")!)
        }
    }
    
    func imageWithImage(image:UIImage, scaledToSize newSize:CGSize) -> UIImage {
            UIGraphicsBeginImageContextWithOptions(newSize, false, 0.0)
            image.draw(in: CGRect(x: 0, y: 0, width: newSize.width, height: newSize.height))
            let newImage:UIImage = UIGraphicsGetImageFromCurrentImageContext()!
            UIGraphicsEndImageContext()
            return newImage
        }
    
    func createImage(count: Int, name: String) -> UIImage? {
        let string = String("\(count) \(name)")
        let paragraphStyle = NSMutableParagraphStyle()
        let font = UIFont.systemFont(ofSize: 20)
        paragraphStyle.alignment = .center
        let attributes: [NSAttributedString.Key: Any] = [
            .font : font,
            .foregroundColor: UIColor.black,
            .paragraphStyle: paragraphStyle
        ]
        
        let attrStr = NSAttributedString(string: string, attributes: attributes)

        let image = self.imageWithImage(image: UIImage(systemName: "circle")!, scaledToSize: CGSize(width: 100, height: 100))
        UIGraphicsBeginImageContext(image.size)
        UIGraphicsBeginImageContextWithOptions(image.size, false, 0.0)
        let rect = CGRect(x: 0, y: 30, width: CGFloat(image.size.width), height: CGFloat(image.size.height))
        attrStr.draw(in: rect)
        image.draw(in: CGRect(x: 0, y: 0, width: CGFloat(image.size.width), height: CGFloat(image.size.height)))
        let markerImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()

        return markerImage
    }
}

struct SmooMarkerSample: View {
    var body: some View {
        SmooMarker()
    }
}

struct SmooMarker_Previews: PreviewProvider {
    static var previews: some View {
        SmooMarkerSample()
    }
}
