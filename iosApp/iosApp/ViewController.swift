import UIKit
import app
import SnapKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = UIColor.white
        
        showItems(items: ["A", "B", "C"].map { "Fact: " + $0 })
    }
    
    func showItems(items: [String]) {
        let scrollView = UIScrollView()
        view.addSubview(scrollView)
        scrollView.snp_makeConstraints { (make) in
            make.edges.equalTo(view)
        }
        
        let contentView = UIView()
        scrollView.addSubview(contentView)
        contentView.snp_makeConstraints { (make) in
            make.top.bottom.equalTo(scrollView)
            make.left.right.equalTo(view)
        }
        
        var prev: UIView = contentView
        let last = items.last
        
        for i in items {
            let label = UILabel()
            contentView.addSubview(label)
            label.numberOfLines = 0
            label.text = String(i)
            
            label.snp_makeConstraints { (make) in
                make.left.right.equalTo(contentView).inset(30)
                make.top.equalTo(prev).offset(30)
                if i == last {
                    make.bottom.equalTo(contentView).offset(-20)
                }
            }
            prev = label
        }
    }
}
