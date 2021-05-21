//
//  HostingViewController.swift
//  SMOO
//
//  Created by 허재 on 2021/05/22.
//

import SwiftUI

class HostingController<ContentView>: UIHostingController<ContentView> where ContentView : View {
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .darkContent
    }
}
