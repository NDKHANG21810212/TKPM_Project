import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchAllUsers } from '../../redux/userSlice'; // Điều chỉnh đường dẫn nếu cần

const UserList = () => {
  const dispatch = useDispatch();
  const { users, loading, error } = useSelector((state) => state.user);

  // Khi component được render, dispatch action để lấy danh sách người dùng
  useEffect(() => {
    dispatch(fetchAllUsers());
  }, [dispatch]);

  // Hiển thị trạng thái loading nếu dữ liệu chưa được tải
  if (loading) return <p>Loading...</p>;

  // Hiển thị thông báo lỗi nếu có
  if (error) return <p>Error: {error}</p>;

  return (
      <div>
        <h2>User List</h2>
        <ul>
          {/* Duyệt qua danh sách người dùng và hiển thị tên người dùng */}
          {users.map((user) => (
              <li key={user.id}>{user.username}</li>
          ))}
        </ul>
      </div>
  );
};

export default UserList;
