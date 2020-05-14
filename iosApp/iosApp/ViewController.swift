import UIKit
import app
import SnapKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = UIColor.white
        
        showItems([ "Fact: A",  "Fact: B",  "Fact: C"])
    }
    
    func showItems(_ items: [String]) {
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
        
        let fullText = items.joined(separator: "\n\n")
        
        let label = UILabel()
        contentView.addSubview(label)
        label.numberOfLines = 0
        label.text = fullText
        
        label.snp_makeConstraints { (make) in
            make.left.right.equalTo(contentView).inset(30)
            make.top.equalTo(contentView).offset(30)
            make.bottom.equalTo(contentView).offset(-20)
        }
    }
}
