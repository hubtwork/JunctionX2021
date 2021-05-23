//
//  CircleImageViw.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import SwiftUI
import URLImage

struct CircleImageView: View {
    
    let imageURL: String?
    
    var body: some View {
        
        if imageURL != nil {
            URLImage(URL(string: imageURL!)!) { image in
                image
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .clipShape(Circle())
                    .overlay(Circle().stroke(Color.black, lineWidth: 0.1))
                    .shadow(radius: 1)
            }
        } else {
            Image(systemName: "person.fill")
                .resizable()
                .aspectRatio(contentMode: .fit)
                .clipShape(Circle())
                .overlay(Circle().stroke(Color.black, lineWidth: 0.1))
                .shadow(radius: 1)
        }
    }
}

struct CircleImageView_Previews: PreviewProvider {
    static var previews: some View {
        VStack {
            CircleImageView(imageURL: nil)
                .frame(width: 50, height: 50)
            
            CircleImageView(imageURL: "https://i.imgur.com/d5G3whb.png")
                .frame(width: 50, height: 50)
        }
    }
}
