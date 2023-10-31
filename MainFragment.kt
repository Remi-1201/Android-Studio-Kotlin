import ...
---
//    Đây là khai báo một lớp MainFragment mà mở rộng từ lớp Fragment.
//    Fragment là một phần của giao diện người dùng trong Android,
//    cho phép bạn hiển thị nội dung trên màn hình.
class MainFragment : Fragment() {

//    Đây là một companion object (đối tượng đồng hành) được sử dụng
//    để cung cấp một cách tiện lợi để tạo một instance mới của MainFragment.
//    Hàm newInstance() sẽ tạo và trả về một đối tượng MainFragment.
    companion object {
        fun newInstance() = MainFragment()
    }
//    private: Đây là một phạm vi truy cập của biến. Trong trường hợp này, private có nghĩa là biến viewModel và binding chỉ có thể truy cập từ bên trong lớp MainFragment. Không thể truy cập chúng từ bên ngoài lớp này.
//    lateinit: Đây là từ khóa cho biết rằng biến viewModel và binding sẽ được khởi tạo sau khi lớp MainFragment được tạo. Thường thì các biến phải được khởi tạo ngay khi khai báo, nhưng với lateinit,  có thể khai báo một biến mà không cần gán giá trị ban đầu.
    private lateinit var viewModel: MainViewModel
//    viewModel là một biến để lưu trữ thông tin và logic liên quan đến dữ liệu và hành vi của màn hình. Nó tương ứng với lớp MainViewModel, và chúng ta sẽ sử dụng nó để quản lý và truy cập dữ liệu cho màn hình này.
    private lateinit var binding: MainFragmentBinding
//    binding là một biến để kết nối các phần tử giao diện người dùng (như nút bấm, văn bản, hình ảnh, v.v.) với mã lập trình. Nó tương ứng với lớp MainFragmentBinding, và chúng ta sử dụng nó để "gắn kết" (bind) các thành phần giao diện người dùng với dữ liệu và hành vi từ viewModel.

//   onCreateView là một phương thức của Fragment được gọi khi Fragment này cần hiển thị giao diện người dùng của nó. Nhiệm vụ chính của nó là "kết nối" giao diện người dùng (layout) với mã lập trình và sau đó trả về giao diện người dùng đã được kết nối để hiển thị trên màn hình.
//    inflater: LayoutInflater: Tham số này là một đối tượng LayoutInflater. LayoutInflater được sử dụng để biên dịch (inflate) một layout XML thành các đối tượng View trong Android. Trong phương thức onCreateView, chúng ta sử dụng inflater để biên dịch layout XML (trong trường hợp này là main_fragment.xml) thành một cấu trúc View để hiển thị trên màn hình.
//
//    container: ViewGroup?: Tham số này là một đối tượng ViewGroup tượng trưng cho một phần của giao diện người dùng, thường là một layout chứa Fragment. Tuy nhiên, nó có thể là null nếu Fragment không được gắn kết với bất kỳ ViewGroup nào. Trong phương thức onCreateView, chúng ta sử dụng container để xác định nơi Fragment sẽ được đặt vào trong giao diện người dùng.
//
//    savedInstanceState: Bundle?: Tham số này là một đối tượng Bundle chứa thông tin trạng thái trước đó của Fragment (nếu có). Nó cung cấp thông tin về trạng thái của Fragment trước khi nó bị hủy hoặc bị tạm ngưng. Trong phương thức onCreateView, savedInstanceState có thể được sử dụng để khôi phục trạng thái trước đó của Fragment nếu cần thiết.
    override fun onCreateView(
        inflater: LayoutInflater
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // sử dụng DataBindingUtil.inflate để "kết nối" giao diện người dùng từ tệp main_fragment.xml vào mã lập trình. Sau đó, nó gán kết quả vào biến binding để chúng ta có thể sử dụng nó để truy cập các phần tử giao diện người dùng.
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
//        Dòng này đặt Fragment hiện tại (this) làm "chủ sở hữu vòng đời" cho binding.
//        Điều này có nghĩa là binding sẽ tự động cập nhật giao diện người dùng khi dữ liệu trong ViewModel thay đổi,
//        giúp đồng bộ hóa hiển thị giao diện người dùng với dữ liệu.
        binding.setLifecycleOwner(this)
        // Trả về giao diện người dùng được liên kết (bằng "binding") để hiển thị trên màn hình.
        // Điều này làm cho Fragment hiển thị giao diện người dùng đã được xây dựng từ layout "main_fragment.xml".
        return binding.getRoot()
    }

//    Trong hàm này, onActivityCreated là một phương thức được gọi khi hoạt động (Activity) đã được tạo.
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        Chúng ta sử dụng ViewModelProvider để tạo một đối tượng MainViewModel và gán nó vào biến viewModel.
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        Sau đó, chúng ta gán viewModel cho biến binding.viewmodel,        
//        điều này cho phép dữ liệu trong ViewModel được hiển thị
//        và tương tác với giao diện người dùng thông qua Data Binding.
        binding.viewmodel = viewModel
    }
}
  
