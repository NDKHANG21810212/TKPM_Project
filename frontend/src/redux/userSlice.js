import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

// Khởi tạo axios instance với base URL của API backend
const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080',
});

// Async thunk để thực hiện gọi API đăng nhập
export const loginUser = createAsyncThunk(
    'user/login',
    async ({ username, password }, { rejectWithValue }) => {
        try {
            const response = await axiosInstance.post('/api/users/login', { username, password });
            const token = response.data.token;

            // Lưu token vào localStorage
            localStorage.setItem('accessToken', token);

            // Giải mã token để lấy thông tin người dùng
            return { username: response.data.username, role: response.data.role };
        } catch (error) {
            return rejectWithValue(error?.response?.data || 'Something went wrong');
        }
    }
);

// Async thunk để lấy tất cả người dùng từ API
export const fetchAllUsers = createAsyncThunk(
    'user/fetchAllUsers',
    async () => {
        const response = await axiosInstance.get('/api/users');
        return response.data;  // Giả sử API trả về danh sách người dùng
    }
);

const userSlice = createSlice({
    name: 'user',
    initialState: {
        userInfo: JSON.parse(localStorage.getItem('userInfo')) || null,
        isLoggedIn: !!localStorage.getItem('accessToken'),
        users: [],  // Thêm state cho danh sách người dùng
    },
    reducers: {
        logout: (state) => {
            localStorage.removeItem('accessToken');
            state.userInfo = null;
            state.isLoggedIn = false;
        },
        login: (state, action) => {
            state.userInfo = action.payload;
            state.isLoggedIn = true;
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(loginUser.fulfilled, (state, action) => {
                state.userInfo = action.payload;
                state.isLoggedIn = true;
            })
            .addCase(fetchAllUsers.fulfilled, (state, action) => {
                state.users = action.payload;  // Lưu danh sách người dùng vào state
            });
    },
});

export const { logout, login } = userSlice.actions;

export default userSlice.reducer;
