//
//  GoogleMapsView.swift
//  SMOO
//
//  Created by 허재 on 2021/05/23.
//

import SwiftUI
import GoogleMaps

struct GoogleMapsView: UIViewRepresentable {
    
    let eventLocation: Location
    
    let users: [UserWithLocation]
    
    private let zoom: Float = 15.0
    
    func makeUIView(context: Self.Context) -> GMSMapView {
        let camera = GMSCameraPosition.camera(withLatitude: eventLocation.lat, longitude: eventLocation.long, zoom: 17)
        let mapView = GMSMapView.map(withFrame: CGRect.zero, camera: camera)
        return mapView
    }
    
    func updateUIView(_ mapView: GMSMapView, context: Context) {
        for user in users {
            let marker: GMSMarker = GMSMarker()
            marker.position = CLLocationCoordinate2D(latitude: user.loc.lat, longitude: user.loc.long)
            marker.title = user.userName
            marker.icon = UIImage(named: "marker")
            marker.map = mapView
        }
    }
}
