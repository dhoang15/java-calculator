# Java Calculator

Ứng dụng máy tính desktop đơn giản viết bằng Java Swing, tổ chức theo mô hình MVC (Model - View - Controller). Ứng dụng hỗ trợ các phép cộng, trừ, nhân, chia, xóa dữ liệu và hiển thị lỗi nhập liệu hoặc chia cho 0.

## 1. Yêu cầu môi trường

- Git để tải project về máy.
- Java Development Kit (JDK) 8 trở lên.
- Khuyến nghị dùng JDK 17 trở lên.
- Windows PowerShell, Command Prompt hoặc terminal tương đương.

## 2. Chức năng

- Nhập chữ số từ `0` đến `9`.
- Cộng hai số bằng nút `+`.
- Trừ hai số bằng nút `-`.
- Nhân hai số bằng nút `*`.
- Chia hai số bằng nút `/`.
- Tính kết quả bằng nút `=`.
- Xóa màn hình và trạng thái phép tính bằng nút `C`.
- Hiển thị lỗi khi dữ liệu trên màn hình không thể chuyển thành số.
- Hiển thị lỗi `Loi chia cho khong` khi chia cho 0.

## 3. Cách sử dụng giao diện

1. Khởi động ứng dụng.
2. Nhấn các nút số để nhập số thứ nhất.
3. Nhấn một trong các nút `+`, `-`, `*`, `/`.
4. Nhấn các nút số để nhập số thứ hai.
5. Nhấn `=` để xem kết quả.
6. Nhấn `C` để xóa màn hình và bắt đầu lại.

Ví dụ: nhấn `4`, `+`, `2`, `=` sẽ hiển thị `6.0`.

## 4. Clone, biên dịch và chạy project

### Bước 1: Clone project

Mở PowerShell hoặc Command Prompt, chuyển đến thư mục bạn muốn lưu project rồi chạy:

```powershell
git clone https://github.com/dhoang15/java-calculator.git
cd java-calculator
```

Nếu đã clone project trước đó và muốn lấy phiên bản mới nhất:

```powershell
cd java-calculator
git pull origin main
```

### Bước 2: Kiểm tra Git và Java

```powershell
git --version
java -version
javac -version
```

Nếu các lệnh trên không chạy được, hãy cài Git và JDK, sau đó mở lại terminal. Biến môi trường `PATH` phải chứa thư mục `bin` của JDK để dùng được `java` và `javac`.

### Bước 3: Biên dịch mã nguồn

Đang ở thư mục gốc `java-calculator`, chạy lệnh sau trong PowerShell:

Tạo thư mục chứa file `.class` và biên dịch toàn bộ mã nguồn:

```powershell
New-Item -ItemType Directory -Force out
javac -d out (Get-ChildItem src -Recurse -Filter *.java).FullName
```

Lệnh này biên dịch tất cả file `.java` trong `src` và đặt file `.class` vào thư mục `out`.

### Bước 4: Chạy giao diện máy tính

```powershell
java -cp out view.CaculatorView
```

Sau khi chạy thành công, cửa sổ máy tính Swing sẽ xuất hiện. Nhấn `Ctrl+C` trong terminal để dừng chương trình nếu cần.

### Bước 5: Chạy kiểm thử thủ công

```powershell
java -cp out test.test
```

Kết quả mong đợi của phần kiểm thử model:

```text
6.0
2.0
8.0
2.0
```

Chương trình kiểm thử cũng mở giao diện Swing ở cuối hàm `main`, vì vậy cửa sổ máy tính sẽ xuất hiện sau khi các kết quả trên được in ra.

### Nếu dùng Command Prompt thay vì PowerShell

Lệnh `Get-ChildItem` là cú pháp PowerShell. Trong Command Prompt, có thể biên dịch bằng lệnh sau:

```cmd
if not exist out mkdir out
javac -d out src\Controller\CaculatorListener.java src\model\CaculatorModel.java src\model\EvalException.java src\test\test.java src\view\CaculatorView.java
```

Sau đó chạy ứng dụng bằng lệnh:

```cmd
java -cp out view.CaculatorView
```

## 5. Cấu trúc thư mục

```text
simplecalculator/
├── MyCaculator.iml
├── README.md
└── src/
	├── Controller/
	│   └── CaculatorListener.java
	├── model/
	│   ├── CaculatorModel.java
	│   └── EvalException.java
	├── test/
	│   └── test.java
	└── view/
		└── CaculatorView.java
```

## 6. Kiến trúc MVC

### Model: `model.CaculatorModel`

Model lưu hai toán hạng, kết quả và phép toán hiện tại:

- `firstValue`: số thứ nhất.
- `secondValue`: số thứ hai.
- `result`: kết quả tính toán.
- `mathOperation`: phép toán hiện tại (`+`, `-`, `*` hoặc `/`).

Các phương thức tính toán gồm:

- `sum()` thực hiện phép cộng.
- `sub()` thực hiện phép trừ.
- `mul()` thực hiện phép nhân.
- `div()` thực hiện phép chia và ném `EvalException` nếu số thứ hai bằng 0.
- `clear()` đưa toàn bộ trạng thái về giá trị ban đầu.

Model cung cấp getter/setter cho các thuộc tính để View có thể đọc và cập nhật dữ liệu.

### View: `view.CaculatorView`

View là một `JFrame` của Swing. Lớp này:

- Tạo cửa sổ kích thước `300 x 350`.
- Tạo ô hiển thị kết quả ở phía trên.
- Tạo bàn phím 4 x 4 gồm các nút số, phép toán, `C` và `=`.
- Gọi Model khi người dùng chọn phép toán.
- Hiển thị kết quả hoặc thông báo lỗi lên ô hiển thị.

### Controller: `Controller.CaculatorListener`

Controller cài đặt `ActionListener`, đọc lệnh từ nút được nhấn rồi gọi phương thức tương ứng trên View:

- Nút số gọi `append()`.
- Nút phép toán gọi `sum()`, `sub()`, `mul()` hoặc `div()`.
- Nút `C` gọi `clear()`.
- Nút `=` gọi `equals()`.

### Exception: `model.EvalException`

`EvalException` là checked exception riêng của ứng dụng, hiện được dùng để báo lỗi chia cho 0 trong Model.

## 7. Luồng xử lý phép tính

Ví dụ với phép cộng `4 + 2 =`:

1. Người dùng nhấn `4`; Controller chuyển ký tự `4` cho View.
2. View nối `4` vào `displayField`.
3. Người dùng nhấn `+`; View đọc `4`, lưu vào `firstValue` và lưu phép toán `+`.
4. Người dùng nhấn `2`; View hiển thị số thứ hai.
5. Người dùng nhấn `=`; View đọc `2`, lưu vào `secondValue` và gọi `Model.sum()`.
6. View lấy `result` từ Model và hiển thị `6.0`.

## 8. Kiểm thử hiện có

File `src/test/test.java` là chương trình kiểm thử thủ công, hiện kiểm tra:

- `4 + 2 = 6.0`.
- `4 - 2 = 2.0`.
- `4 * 2 = 8.0`.
- `4 / 2 = 2.0`.
- Khởi tạo giao diện Swing.

Có thể kiểm tra chia cho 0 bằng cách thay `setSecondValue(2)` thành `setSecondValue(0)` trong phần kiểm thử phép chia. Khi đó chương trình sẽ in thông báo `Loi chia cho khong`.

## 9. Giới hạn hiện tại

- Chỉ có các nút số nguyên từ `0` đến `9`; chưa có nút dấu chấm thập phân.
- Chưa có nút đổi dấu số âm.
- Chưa hỗ trợ nhập bằng bàn phím máy tính.
- Chưa hỗ trợ chuỗi nhiều phép tính liên tiếp như `2 + 3 * 4`.
- Chưa hỗ trợ ngoặc, phần trăm, căn bậc hai hoặc các phép tính nâng cao.
- Sau khi nhấn một phép toán, ứng dụng kỳ vọng người dùng nhập số thứ hai rồi nhấn `=`.
- Kết quả được hiển thị theo kiểu `double`, nên số nguyên có thể xuất hiện dưới dạng `6.0`.
- Bộ kiểm thử hiện là chương trình `main` thủ công, chưa dùng JUnit.

## 10. Ghi chú phát triển

- Giữ đúng tên package hiện tại: `model`, `view`, `Controller`, `test`.
- Khi thêm phép toán mới, cần cập nhật Model, nút tương ứng trong View và phần định tuyến trong `CaculatorListener`.
- Khi thay đổi cách hiển thị lỗi, cần cập nhật cả logic xóa thông báo lỗi trong `append()`.
- Không đưa các thư mục biên dịch như `out/`, `bin/`, `target/` hoặc cấu hình IDE vào commit; các thư mục này đã được khai báo trong `.gitignore`.

## 11. Giấy phép

Repository hiện chưa khai báo giấy phép phần mềm riêng.
