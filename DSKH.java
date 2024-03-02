package quanlitiendien;
import static quanlitiendien.KhachHang.sc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class DSKH {

    ArrayList<KhachHang> list;

    public DSKH() {
        list = new ArrayList<>();
                    }

                    public void add(KhachHang khachhang) {
                        list.add(khachhang);
                    }

                    public void show() {
                        for (KhachHang khachHang : list) {
                            khachHang.output();
                        }
                    }

                    public double TongSoLuongVN() {
                        double tong = 0;
                        for (KhachHang khachHang : list) {
                            if (khachHang instanceof KhachHangVietNam) {
                                tong =+ khachHang.getSoLuong();
                            }
                        }
                        return tong;
                    }

                    public double tongSoLuongNN() {
                        double tong = 0;
                        for (KhachHang khachHang : list) {
                            if (khachHang instanceof KhachHangNuocNgoai) {
                                tong =+ khachHang.getSoLuong();
                            }
                        }
        return tong;
    }

    public double trungBinhTienNuocNgoai() {
        int tong = 0;
        int n = 0;
        for (KhachHang khachHang : list) {
            if (khachHang instanceof KhachHangNuocNgoai) {
                tong += khachHang.tinhTien();
                ++n;
            }
        }
        return tong / n ;

    }

    public int hoaDon() {
        for (KhachHang khachHang : list) {
            if (khachHang.getNgayHoaDon().getMonth() + 1 == 9 & khachHang.getNgayHoaDon().getYear() + 1900 == 2020) {
                khachHang.output();
            }
        }
    }

    public void menu() {
        int choose = 0;
        while (true) {
            while (true) {
                try {
                    System.out.println("""
                                       =====MENU=====
                                       1. Nhap hoa don
                                       2. Xuat hoa don
                                       3. Tinh tong so luong cho tung loai khach hang
                                       4. Tinh trung binh thanh tien cua khach hang nuoc ngoai
                                       5. Xuat ra cac hoa don thang 5 nam 2013
                                       0.Thoat
                                       Nhap lua chon: """);
                    choose = Integer.parseInt(sc.nextLine());
                    if (choose >= 0 & choose <= 5) {
                        break;
                    } else {
                        System.err.println("Nhap lai");
                    }
                } catch (Exception e) {
                    System.err.println("Nhap lai");
                }
            }

            if (choose == 1) {
                while (true) {
                    int choose1 = 0;
                    while (true) {
                        try {
                            System.out.println("""
                                   =====MENU NHAP HOA DON=====
                                   1. Khach hang Viet Nam
                                   2. Khach hang nuoc ngoai
                                   0. Thoat""");
                            choose1 = Integer.parseInt(sc.nextLine());
                            if (choose1 >= 0 && choose1 <= 2) {
                                break;
                            } else {
                                System.err.println("Nhap lai");
                            }
                        } catch (Exception e) {
                            System.err.println("Nhap lai");
                        }
                    }

                    if (choose1 == 1) {
                        KhachHang kh = new KhachHangVietNam();
                        kh.input();
                        list.add(kh);
                    } else if (choose1 == 2) {
                        KhachHang kh = new KhachHangNuocNgoai();
                        kh.input();
                        list.add(kh);
                    } else {
                        break;
                    }
                }

            } else if (choose == 2) {
                System.out.println("=====SHOW LIST=====");
                show();
            } else if (choose == 3) {
                int c = 0;
                while (true) {
                    try {
                        System.out.println("""
                                   1. Khach Hang Viet Nam
                                   2. Khach Hang Nuoc Ngoai
                                   Nhap lua chon: """);
                        c = Integer.parseInt(sc.nextLine());
                        if (c >= 1 && c <= 2) {
                            break;
                        } else {
                            System.err.println("Nhap lai");
                        }
                    } catch (Exception e) {
                        System.err.println("Nhap lai");
                    }
                }
                if (c == 1) {
                    System.out.println("Tong so luong cua KH Viet Nam: " + TongSoLuongVN());
                } else {
                    System.out.println("Tong so luong KH nuoc ngoai: " + tongSoLuongNN());
                }

            } else if (choose == 4) {
                System.out.println("Trung binh thanh tien cua KH nuoc ngoai: " + trungBinhTienNuocNgoai());
            } else if (choose == 5) {
                System.err.println("Cac hoa don trong thang 9 nam 2020");
                hoaDon();
            } else {
                break;
            }
        }
    }
}

