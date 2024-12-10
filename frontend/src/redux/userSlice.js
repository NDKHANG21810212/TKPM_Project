import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';
import { jwtDecode } from 'jwt-decode';  // Đảm bảo import jwtDecode

// Khởi tạo axios instance với base URL của API backend
const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080', // URL của backend (thay đổi nếu cần)
});

// Async thunk để thực hiện gọi API đăng nhập
export const loginUser = createAsyncThunk(
    'user/login',
    async ({ username, password }, { rejectWithValue }) => {
        try {
            const response = await axiosInstance.post('/api/users/login', { username, password });
            const token = response.data.token; // Giả sử token trả về trong trường 'token'

            // Lưu token vào localStorage
            localStorage.setItem('accessToken', token);

            // Giải mã token để lấy thông tin người dùng
            const decodedToken = jwtDecode(token);
            const userRole = decodedToken.role || 'USER';
            const userName = decodedToken.sub;

            // Lưu vai trò vào localStorage
            localStorage.setItem('role', userRole);
            localStorage.setItem('userInfo', JSON.stringify({ username: userName, role: userRole }));

            // Trả về thông tin người dùng
            return { username: userName, role: userRole };
        } catch (error) {
            return rejectWithValue(error?.response?.data || 'Something went wrong');
        }
    }
);

// Async thunk để lấy danh sách người dùng
export const fetchAllUsers = createAsyncThunk(
    'user/fetchAllUsers',
    async (_, { rejectWithValue }) => {
        try {
            const response = await axiosInstance.get('/api/users');
            return response.data;  // Giả sử dữ liệu trả về là một danh sách người dùng
        } catch (error) {
            return rejectWithValue(error?.response?.data || 'Something went wrong');
        }
    }
);

// Slice để quản lý trạng thái người dùng
const userSlice = createSlice({
    name: 'user',
    initialState: {
        userInfo: JSON.parse(localStorage.getItem('userInfo')) || null,  // Lấy thông tin người dùng từ localStorage
        users: [],
        loading: false,
        error: null,
        isLoggedIn: !!localStorage.getItem('accessToken'),  // Kiểm tra token trong localStorage để xác định trạng thái đăng nhập
    },
    reducers: {
        // Đăng xuất người dùng
        logout: (state) => {
            localStorage.removeItem('accessToken');
            localStorage.removeItem('role');
            localStorage.removeItem('userInfo');
            state.userInfo = null;
            state.isLoggedIn = false;
        },
        // Đăng nhập người dùng
        login: (state, action) => {
            state.userInfo = action.payload;  // Thông tin người dùng sau khi đăng nhập
            state.isLoggedIn = true;
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(loginUser.pending, (state) => {
                state.loading = true;
            })
            .addCase(loginUser.fulfilled, (state, action) => {
                state.loading = false;
                state.userInfo = action.payload;
                state.isLoggedIn = true;  // Đánh dấu người dùng đã đăng nhập
            })
            .addCase(loginUser.rejected, (state, action) => {
                state.loading = false;
                state.error = action.payload;
            })
            .addCase(fetchAllUsers.pending, (state) => {
                state.loading = true;
            })
            .addCase(fetchAllUsers.fulfilled, (state, action) => {
                state.loading = false;
                state.users = action.payload;  // Cập nhật danh sách người dùng
            })
            .addCase(fetchAllUsers.rejected, (state, action) => {
                state.loading = false;
                state.error = action.payload;
            });
    },
});

// Export các actions để sử dụng
export const { logout, login } = userSlice.actions;

export default userSlice.reducer;
